impl Solution {
    pub fn maximum_unique_subarray(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut start = 0;
        let mut end = 0;
        let mut sum = 0;
        let mut map = std::collections::HashMap::new();
        while end < nums.len() {
            let num = nums[end];
            if let Some(&pos) = map.get(&num) {
                for i in start..pos {
                    map.remove(&nums[i]);
                    sum -= nums[i];
                }
                start = pos + 1;
            }
            map.insert(num, end);
            sum += num;
            max = std::cmp::max(max, sum);
            end += 1;
        }
        max
    }
}