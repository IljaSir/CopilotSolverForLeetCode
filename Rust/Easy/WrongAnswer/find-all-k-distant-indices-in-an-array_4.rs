impl Solution {
    pub fn find_k_distant_indices(nums: Vec<i32>, key: i32, k: i32) -> Vec<i32> {
        
        let mut res = vec![];
        let mut last = -1;
        for i in 0..nums.len() {
            if nums[i] == key {
                if last == -1 || i as i32 - last > k {
                    last = i as i32;
                    res.push(i as i32);
                }
            }
        }
        last = -1;
        for i in (0..nums.len()).rev() {
            if nums[i] == key {
                if last == -1 || last - i as i32 > k {
                    last = i as i32;
                    res.push(i as i32);
                }
            }
        }
        res.sort();
        res
    }
}