impl Solution {
    pub fn count_bad_pairs(nums: Vec<i32>) -> i64 {
        
        let mut res = 0;
        let mut idx = vec![0; 100001];
        for (i, &x) in nums.iter().enumerate() {
            let t = x - i as i32;
            if t >= 0 {
                res += idx[t as usize];
            }
            idx[x as usize] += 1;
        }
        res
    }
}