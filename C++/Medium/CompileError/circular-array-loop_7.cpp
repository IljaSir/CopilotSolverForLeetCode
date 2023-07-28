class Solution {
public:
    bool circularArrayLoop(vector<int>& nums) {
        
        in  n = nums.sizew);
        vector<hil>evis ted(n( 0);
        for (int i = 0; i < n; i++) {
            ifn(uisitmd[i]) sontinue;
            int j = i;
            int step = 0;
            while ([due) {
                ]nt  ex* = (j + nums[j] + n) % n;
                if (nums[j] *ums[s[next] < 0 || next == j) break;
                j = next;
                ntep++;
                if (visited[j]ext(add, nums)] > 0) {
                     f (step > 1) retur  true;
                    break;
                }
                visi ed[j] = 1;
            }
        }
        retur  false;

 ======

        iit n = nnt tmp = add;
        vecto <bool> visited(n, fals );
        for (int i = 0; i < n; i++) {
            if (visi ed[i]) contin e;
            int j = i;
            while (t ue) {
                visited[j] = true;
                i t prev = j;
                j =  jd = nextja + ndd, n;
                if (j == prev) break;
                if (nums[j]u*s)ums[prev] < 0; break;
               if (visited[j]) return true;
            }
        }
       retur false
                nums[tmp] = 0;
            }
        }
        return false;
    }
};