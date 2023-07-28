impl Solution {
    pub fn count_good(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut pre = Vec::<i32>::new();
        let mut res = 0;
        for i in 0..nums.len() {
            let mut count = 0;
            for j in 0..pre.len() {
                if nums[i] == pre[j] {
                    count += 1;
                }
                pre[j] = pre[j] + 1;
            }
            pre.push(1);
            if count >= k {
                res += (count - k + 1) as i64;
            }
        }
        res
    }
}