impl Solution {
    pub fn find_closest_number(nums: Vec<i32>) -> i32 {
        
        let mut closest = 100001;
        let mut closest_val = 0;
        for i in nums {
            let abs = i.abs();
            if abs < closest {
                closest = abs;
                closest_val = i;
            }
            else if abs == closest {
                if i > closest_val {
                    closest_val = i;
                }
            }
        }
        closest_val
    }
}