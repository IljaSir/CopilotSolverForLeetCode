impl Solution {
    pub fn valid_partition(nums: Vec<i32>) -> bool {
        
        let mut count = vec![0; 1000010];
        for n in nums.iter() {
            count[*n as usize] += 1;
        }
        let mut flag = false;
        let mut i = 0;
        while i < count.len() {
            if count[i] >= 2 {
                flag = true;
                break;
            }
            i += 1;
        }
        if !flag {
            return false;
        }
        let mut i = 0;
        while i < count.len() {
            if count[i] >= 3 {
                return true;
            }
            i += 1;
        }
        let mut i = 0;
        while i < count.len() - 2 {
            if count[i] >= 1 && count[i + 1] >= 1 && count[i + 2] >= 1 {
                return true;
            }
            i += 1;
        }
        false
    }
}