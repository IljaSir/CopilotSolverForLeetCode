impl Solution {
    pub fn valid_partition(nums: Vec<i32>) -> bool {
        
        let mut count = vec![0; 1000000];
        for n in &nums {
            count[*n as usize - 1] += 1;
        }
        let mut max = 0;
        let mut max_count = 0;
        for n in &count {
            if *n > 0 {
                if *n > max_count {
                    max_count = *n;
                    max = n;
                } else if *n == max_count {
                    max = 0;
                }
            }
        }
        if max_count >= 3 {
            return true;
        }
        if max_count == 2 {
            let mut first = -1;
            let mut second = -1;
            for i in 0..nums.len() {
                if nums[i] == max {
                    first = i as i32;
                    break;
                }
            }
            for i in (0..nums.len()).rev() {
                if nums[i] == max {
                    second = i as i32;
                    break;
                }
            }
            if second - first >= 2 {
                return true;
            }
        }
        let mut first = -1;
        let mut second = -1;
        let mut third = -1;
        for i in 0..nums.len() {
            if nums[i] == max + 1 {
                if first == -1 {
                    first = i as i32;
                } else if second == -1 {
                    second = i as i32;
                } else if third == -1 {
                    third = i as i32;
                } else {
                    return true;
                }
            }
        }
        false
    }
}