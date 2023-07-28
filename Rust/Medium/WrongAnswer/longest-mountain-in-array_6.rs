impl Solution {
    pub fn longest_mountain(arr: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut i = 1;
        let mut up = false;
        let mut down = false;
        let mut count = 1;
        while i < arr.len() {
            if arr[i] > arr[i - 1] {
                if down {
                    if count > max {
                        max = count;
                    }
                    count = 2;
                    down = false;
                } else {
                    count += 1;
                }
                up = true;
            } else if arr[i] < arr[i - 1] {
                if up {
                    count += 1;
                    down = true;
                }
            } else {
                if count > max {
                    max = count;
                }
                count = 1;
                up = false;
                down = false;
            }
            i += 1;
        }
        if down && count > max {
            max = count;
        }
        max
    }
}