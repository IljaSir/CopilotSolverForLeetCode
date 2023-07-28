class Solution {
    public int longestSubstring(String s, int k) {
        
        int n = s.length();
        int ans = 0;
        for (int i = 1; i <= 26; i++) {
            ans = Math.max(ans, helper(s, k, i));
        }
        return ans;
    }
rt);
                }
            }
        }
        return ans;
    }
}