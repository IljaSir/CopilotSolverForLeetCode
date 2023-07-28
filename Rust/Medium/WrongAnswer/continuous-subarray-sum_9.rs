impl Solution {
    pub fn check_subarray_sum(nums: Vec<i32>, k: i32) -> bool {
        

        let mut acc = 0;
        let mut rem = 0;
        let mut seen = std::collections::HashMap::new();
        for num in nums {
            acc += num;
            if k > 0 {
                rem = acc % k;
            }
            if let Some(&prev) = seen.get(&rem) {
                if prev + 1 < acc {
                    return true;
                }
            } else {
                seen.insert(rem, acc);
            }
        }
        false
    }
}