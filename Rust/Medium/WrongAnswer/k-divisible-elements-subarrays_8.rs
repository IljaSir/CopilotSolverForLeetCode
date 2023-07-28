impl Solution {
    pub fn count_distinct(nums: Vec<i32>, k: i32, p: i32) -> i32 {
        
        let mut count = 0;
        let mut v = vec![0;nums.len()+1];
        for i in 0..nums.len() {
            v[i+1] = (v[i] + nums[i]) % p;
        }
        for i in 0..nums.len() {
            let mut map = std::collections::HashMap::new();
            for j in i..nums.len() {
                if j-i+1 > k as usize {
                    break;
                }
                let val = (v[j+1] - v[i]) % p;
                if val < 0 {
                    map.entry(val + p).or_insert(0);
                } else {
                    map.entry(val).or_insert(0);
                }
            }
            count += map.len() as i32;
        }
        count
    }
}