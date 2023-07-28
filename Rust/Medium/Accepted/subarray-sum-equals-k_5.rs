impl Solution {
    pub fn subarray_sum(nums: Vec<i32>, k: i32) -> i32 {
        

        let mut m: std::collections::HashMap<i32, i32> = std::collections::HashMap::new();
        m.insert(0, 1);
        let mut sum = 0;
        let mut ret = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            if let Some(&v) = m.get(&(sum - k)) {
                ret += v;
            }
            *m.entry(sum).or_insert(0) += 1;
        }
        ret
    }
}