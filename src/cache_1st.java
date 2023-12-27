import java.util.ArrayList;
import java.util.List;

public class cache_1st {

    public static void main(String[] args) {
        int chacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo",
                "Seoul", "NewYork", "LA"};

        Solution sol = new Solution();
        System.out.println(sol.solution(chacheSize, cities));
    }

    static class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            int citiesSize = cities.length;

            if((citiesSize < cacheSize) || (cacheSize == 0))
                return citiesSize * 5;

            List<String> cache = new ArrayList<>();
            for(int i = 0; i< citiesSize; i++){
                cities[i] = cities[i].toLowerCase();

                if(cache.contains(cities[i])) {
                    cache.remove(cities[i]);
                    cache.add(cities[i]);
                    answer += 1;
                    continue;
                }
                if(cache.size() < cacheSize) {
                    cache.add(cities[i]);
                    answer += 5;
                    continue;
                }
                cache.remove(0);
                cache.add(cities[i]);
                answer += 5;
            }

            return answer;
        }
    }
 }
