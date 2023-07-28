impl Solution {
    pub fn find_k_distant_indices(nums: Vec<i32>, key: i32, k: i32) -> Vec<i32> {
        
        let mut res = vec![];
        let (mut i, mut j) = (0, 0);
        while i < nums.len() as i32 {
            if nums[i as usize] == key {
                while j < nums.len() as i32 && j <= i + k {
                    if nums[j as usize] == key {
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