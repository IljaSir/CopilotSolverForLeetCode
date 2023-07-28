impl Solution {
    pub fn longest_mountain(arr: Vec<i32>) -> i32 {
        
        let mut longest = 0;
        let mut i = 1;
        let mut is_mountain = false;
        let mut mountain_start = 0;
        let mut mountain_end = 0;
        let mut mountain_length = 0;
        
        while i < arr.len() {
            if arr[i] > arr[i-1] {
                if is_mountain {
                    mountain_length += 1;
                } else {
                    is_mountain = true;
                    mountain_start = i-1;
                    mountain_length = 2;
                }
            } else if arr[i] < arr[i-1] {
                if is_mountain {
                    mountain_length += 1;
                    mountain_end = i;
                } else {
                    mountain_start = i;
                    mountain_length = 1;
                }
            } else {
                if is_mountain {
                    is_mountain = false;
                    if mountain_length > longest {
                        longest = mountain_length;
                    }
                }
            }
            i += 1;
        }
        
        if is_mountain && mountain_length > longest {
            longest = mountain_length;
        }
        
        longest as i32
    }
}