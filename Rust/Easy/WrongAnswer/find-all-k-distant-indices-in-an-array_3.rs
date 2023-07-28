impl Solution {
    pub fn find_k_distant_indices(nums: Vec<i32>, key: i32, k: i32) -> Vec<i32> {
        
        let mut res: Vec<i32> = Vec::new();
        let mut i = 0;
        while i < nums.len() {
            if nums[i] == key {
                let mut j = i as i32 - k;
                while j <= i as i32 + k {
                    if j >= 0 && j < nums.len() as i32 && nums[j as usize] == key {
                        res.push(j);
                    }
                    j += 1;
                }
            }
            i += 1;
        }
        res
    }
}