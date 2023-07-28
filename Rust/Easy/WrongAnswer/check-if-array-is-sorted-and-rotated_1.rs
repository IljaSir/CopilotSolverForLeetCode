impl Solution {
    pub fn check(nums: Vec<i32>) -> bool {
        
        let mut is_sorted = true;
        for i in 0..nums.len() - 1 {
            if nums[i] > nums[i+1] {
                is_sorted = false;
                break;
            }
        }
        if is_sorted {
            return true;
        }
        let mut is_reversed = true;
        for i in 0..nums.len() - 1 {
            if nums[i] < nums[i+1] {
                is_reversed = false;
                break;
            }
        }
        if is_reversed {
            return true;
        }
        let mut is_rotated = true;
        let mut i = 0;
        while i < nums.len() - 1 {
            if nums[i] > nums[i+1] {
                break;
            }
            i += 1;
        }
        let mut j = i + 1;
        while j < nums.len() - 1 {
            if nums[j] > nums[j+1] {
                is_rotated = false;
                break;
            }
            j += 1;
        }
        if is_rotated {
            return true;
        }
        let mut k = j + 1;
        while k < nums.len() - 1 {
            if nums[k] > nums[k+1] {
                is_rotated = false;
                break;
            }
            k += 1;
        }
        if is_rotated {
            return true;
        }
        let mut m = k + 1;
        while m < nums.len() - 1 {
            if nums[m] > nums[m+1] {
                is_rotated = false;
                break;
            }
            m += 1;
        }
        if is_rotated {
            return true;
        }
        false
    }
}