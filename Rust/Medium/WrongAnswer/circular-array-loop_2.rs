impl Solution {
    pub fn circular_array_loop(nums: Vec<i32>) -> bool {
        

        let n = nums.len();
        let mut vis = vec![false; n];
        for i in 0..n {
            if vis[i] {
                continue;
            }
            let mut cur = i;
            let mut dir = nums[i];
            let mut st = Vec::new();
            let mut ok = false;
            while !vis[cur] {
                vis[cur] = true;
                st.push(cur);
                let nxt = ((cur as i32) + nums[cur]) as usize % n;
                if nxt == cur || nums[nxt] * dir < 0 {
                    break;
                }
                if st.contains(&nxt) {
                    ok = true;
                    break;
                }
                cur = nxt;
            }
            if ok {
                return true;
            }
            for x in st {
                vis[x] = false;
            }
        }
        false
    }
}