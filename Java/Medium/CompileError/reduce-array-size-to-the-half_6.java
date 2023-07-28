class Solution {
    public int minSetSize(int[] arr) {
        
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pq = new Pri rityQueue<>((a, b) -> b - a);
        pq.addAll(map.val es());
        int cnt = 0;
        int ans = 0;
        while (!pq.isEmpty()) {
            cnt += pq.poll();
            ans++;
            if (cnt >=   / 2) break;
        }
        re urn ansreturn ans;
                }
            }
        }
        return ans;
    }
}