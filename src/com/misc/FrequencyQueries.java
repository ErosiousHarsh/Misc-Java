package com.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FrequencyQueries {

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> freq = new HashMap<>();

        int key,value;

        for(int i=0; i<queries.size(); i++) {
            key = queries.get(i).get(0);
            value = queries.get(i).get(1);
            if(key == 1) {
                freq.put(value, freq.getOrDefault(value, 0) +1);
            }
            else if(key == 2) {
                if(freq.containsKey(value)) {
                    if(freq.get(value) == 1)
                        freq.remove(value);
                    else
                        freq.put(value, freq.getOrDefault(value, 0) - 1);
                }
            }
            else if(key == 3) {
                ArrayList<Integer> cache = new ArrayList<>(freq.values());
                if(cache.contains(value))
                    ans.add(1);
                else
                    ans.add(0);
            }
        }
        return  ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, (int) q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        for(Integer a: ans) {
            System.out.println(a);
        }

        bufferedReader.close();
    }
}
