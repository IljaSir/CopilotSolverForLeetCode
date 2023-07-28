class Solution {
    public int countAnagrams(String s) {
        
        int ans = 0;
        int n = s.length();
        long mod = 1000000007;
        long[] p = new long[n+1];
        p[0] = 1;
        for(int i=1;i<=n;i++){
            p[i] = (p[i-1]*31)%mod;
        }
        HashMap<Long,Integer> map = new HashMap<>();
        long[] hash = new long[n+1];
        for(int i=0;i<n;i++){
            hash[i+1] = (hash[i]+(s.charAt(i)-'a'+1)*p[i])%mod;
        }
        for(int i=0;i<n;i++){
            if(s.charAt(i)==' ') continue;
            int j = i;
            while(j<n && s.charAt(j)!=' ') j++;
            long hs = hash[j] - hash[i];
            if(hs<0) hs+=mod;
            hs = (hs*p[n-j])%mod;
            map.put(hs,map.getOrDefault(hs,0)+1);
            i = j;
        }
        for(long key : map.keySet()){
            int val = map.get(key);
            ans = (ans+(int)(((long)val*(val-1))/2)%mod)%mod;
        }
        return ans;
    }
}