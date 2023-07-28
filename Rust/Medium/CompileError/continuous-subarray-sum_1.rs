impl Solution {
    pub fn check_subarray_sum(nums: Vec<i32>, k: i32) -> bool {
        

        let mut map: HashMap<i32, i32> = HashMap::new();
        map.insert(0, -1);
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            if k != 0 {
                sum %= k;
            }
            if let Some(&prev) = map.get(&sum) {
                if i as i32 - prev >= 2 {
                    return true;
                }
            } else {
                map.insert(sum, i as i32);
            }
        }
        false
    }
}