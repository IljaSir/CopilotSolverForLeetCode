impl Solution {
    pub fn is_possible(nums: Vec<i32>) -> bool {
        

        let mut count = vec![0; 10001];
        let mut tail = vec![0; 10001];
        for i in nums {
            count[i as usize] += 1;
        }
        for i in nums {
            if count[i as usize] == 0 {
                continue;
            }
            if tail[i as usize - 1] > 0 {
                count[i as usize] -= 1;
                tail[i as usize - 1] -= 1;
                tail[i as usize] += 1;
            } else if count[i as usize + 1] > 0 && count[i as usize + 2] > 0 {
                count[i as usize] -= 1;
                count[i as usize + 1] -= 1;
                count[i as usize + 2] -= 1;
                tail[i as usize + 2] += 1;
            } else {
                return false;
            }
        }
        true
    }
}