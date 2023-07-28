impl Solution {
    pub fn can_choose(groups: Vec<Vec<i32>>, nums: Vec<i32>) -> bool {
        
        let mut i = 0;
        for group in groups {
            let mut found = false;
            while i + group.len() <= nums.len() {
                if nums[i..i + group.len()] == group {
                    found = true;
                    i += group.len();
                    break;
                } else {
                    i += 1;
                }
            }
            if !found {
                return false;
            }
        }
        true
    }
}