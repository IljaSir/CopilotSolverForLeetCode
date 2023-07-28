impl Solution {
    pub fn circular_array_loop(nums: Vec<i32>) -> bool {
        

        let n = nums.len();
        let mut vis = vec![-1; n];
        let mut stk = vec![];
        let mut cur = 0;
        let mut dir = 0;
        let mut cnt = 0;
        while cnt < n {
            if vis[cur] != -1 {
                if stk.len() - vis[cur] > 1 {
                    return true;
                } else {
                    stk.clear();
                    dir = 0;
                    cnt += 1;
                }
            } else {
                vis[cur] = stk.len();
                stk.push(cur);
                cnt += 1;
            }
            let nxt = (cur as i32 + nums[cur]) as usize % n;
            if nums[nxt] * nums[cur] < 0 {
                stk.clear();
                dir = 0;
            } else {
                if dir == 0 {
                    dir = nums[nxt];
                } else if dir != nums[nxt] {
                    stk.clear();
                    dir = 0;
                }
            }
            cur = nxt;
        }
        false
    }
}