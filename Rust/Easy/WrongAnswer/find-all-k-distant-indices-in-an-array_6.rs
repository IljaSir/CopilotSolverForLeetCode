impl Solution {
    pub fn find_k_distant_indices(nums: Vec<i32>, key: i32, k: i32) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut last = -1;
        for i in 0..nums.len() {
            if nums[i] == key {
                if i as i32 - last <= k {
                    res.push(i as i32);
                }
                last = i as i32;
            }
        }
        last = nums.len() as i32;
        for i in (0..nums.len()).rev() {
            if nums[i] == key {
                if last - i as i32 <= k {
                    res.push(i as i32);
                }
                last = i as i32;
            }
        }
        res.sort();
        res
    }
}