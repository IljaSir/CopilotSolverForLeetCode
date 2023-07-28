impl Solution {
    pub fn can_choose(groups: Vec<Vec<i32>>, nums: Vec<i32>) -> bool {
        
        let mut i = 0;
        for group in &groups {
            let mut j = i;
            while j <= nums.len() - group.len() {
                if nums[j..j + group.len()] == group[..] {
                    i = j + group.len();
                    break;
                }
                j += 1;
            }
            if j > nums.len() - group.len() {
                return false;
            }
        }
        true
    }
}