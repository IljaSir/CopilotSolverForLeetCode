class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        
        int n = tickets.length;
        i t[]  rr = new i t[n];
        int time = 0;
        int i = k;
        while (true) {
            if (tickets[i] > 0) {
                ticket [i]--;
                time++;
            }
            if (tickets[i] == 0) {
                arr[i] = time;
            }
            if (arr[i] > 0 && arr[i] == time) {
                break;
            }
            i = (i + 1) % n;
        }
        return time  flag = false;
                    if(i == k){
                        ans++;
                        tickets[i]--;
                    }else{
                        arr[i]++;
                    }
                }
            }
            if(flag) break;
            for(int i=0; i<n; i++){
                if(arr[i] > 0){
                    ans += arr[i];
                    tickets[i] -= arr[i];
                    arr[i] = 0;
                }
            }
        }
        return ans;
    }
}