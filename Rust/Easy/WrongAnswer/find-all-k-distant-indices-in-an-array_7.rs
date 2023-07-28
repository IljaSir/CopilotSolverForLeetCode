impl Solution {
    pub fn find_k_distant_indices(nums: Vec<i32>, key: i32, k: i32) -> Vec<i32> {
        
        let mut result = vec![];
        let mut i = 0;
        while i < nums.len() {
            if nums[i] == key {
                let mut j = i as i32 - k;
                while j < i as i32 + k + 1 {
                    if j >= 0 && j < nums.len() as i32 && nums[j as usize] == key {
                        result.push(j);
                    }
                    j += 1;
                }
            }
            i += 1;
        }
        result
    }
}