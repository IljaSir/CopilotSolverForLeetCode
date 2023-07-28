class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
}ele{
        map.pus(sum{
e.nt;   rur false
    }}
returfalisk=0
===se{-i
n falef(num[i+1] {
            ettfrnutsu.;
            }
   s=0    }
                  tfals tre;
       }
        k = Math.abs(k);   }
        if (k == 0)fals
        };
        int pre = 0
        int sum = 0;   return false;
        }p( + ns)
        int sum = 0;p
        Map<Integer, Integernums.le>gth pma HashMap<>();
       map.(su +ns;
            sum=
        for (int i = 0; i < numssuei++) {
            sum +fn(i-su1
            if (map.contpaium)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }su
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}