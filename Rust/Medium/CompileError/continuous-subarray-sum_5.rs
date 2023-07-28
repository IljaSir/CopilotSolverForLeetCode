impl Solution {
    pub fn check_subarray_sum(nums: Vec<i32>, k: i32) -> bool {
        

        let mut sum: i32 = 0;
        let mut map: HashMap<i32, i32> = HashMap::new();
        map.insert(0, -1);
        for (i, v) in nums.iter().enumerate() {
            sum += v;
            if k != 0 {
                sum %= k;
            }
            if let Some(&j) = map.get(&sum) {
                if i - j > 1 {
                    return true;
                }
            } else {
                map.insert(sum, i as i32);
            }
        }
        false
    }
}