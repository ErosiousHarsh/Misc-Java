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

    static List<Long> freqQuery(List<List<Long>> queries) {
        List<Long> ans = new ArrayList<>();
        List<Long> cache = new ArrayList<>();
        HashMap<Long,Long> freq = new HashMap<>();

        long key,value,c=0;

        for(int i=0; i<queries.size(); i++) {
            key = queries.get(i).get(0);
            value = queries.get(i).get(1);
            if(key == 1) {
                cache.clear();
                freq.put(value, freq.getOrDefault(value, 0L) +1L);
                cache.add(freq.get(value));
            }
            else if(key == 2) {
                if(freq.containsValue(value)) {
                    cache.clear();
                    freq.put(value, freq.getOrDefault(value, 0L) - 1L);
                    cache.add(freq.get(value));
                }
            }
            else if(key == 3) {
                if(cache.contains(value) || freq.containsValue(value))
                    ans.add((long) 1);
                else
                    ans.add((long) 0);
            }
        }
        return  ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Long>> queries = new ArrayList<>();

        IntStream.range(0, (int) q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Long::parseLong)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Long> ans = freqQuery(queries);

        for(Long a: ans) {
            System.out.println(a);
        }

        bufferedReader.close();
    }
}
