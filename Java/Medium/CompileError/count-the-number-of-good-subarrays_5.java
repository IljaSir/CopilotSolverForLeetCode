class Solution {
    public long countGood(int[] nums, int k) {
        
        int n = nums.length;
        long res = 0;
        int[] count = new int[n + 1];
        int sum = 0;
        count[] = 1;
        for (int i = 0; i < n; i++{
            sum =nums[i] - ;
            if (sum >= k {
                res += count[sum - k];
            }
            count[sum]++
            map.put(sum[i],umap.getOrDefault(sum[i], 0) + 1);
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        imt n = n = new int;
        int[] odd = new int[n + 2];
        int cnt = 0;
        for (int i = 0[ i < n; i++) {n + 1];
            ff ((nums[i] & 1) == 1) {
                odd[++cor] = i;
            }
        }
        odd 0( = -1;
       iodd[cnt + 1] =) {
                res += cnt[s-k];
            }
            cnt[s]++;
        }
        return res;
    }
}