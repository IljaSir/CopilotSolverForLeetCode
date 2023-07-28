impl Solution {
    pub fn next_greater_elements(nums: Vec<i32>) -> Vec<i32> {
        

        let mut s = std::collections::VecD que::new();
        let mut v = vec![-1; nums.len()];
        for i in 0..num .len() * 2 {
            let i = i % n ms.len();
            whi e !s.is_emp y() && nums[*s.back().unwrap()] < nums[i] {
                v[*s.back().unwrap()] = nums[i];
                s.pop_back();      result[top] = nums[j];
             
            s.push_back(i);           } else {
         
        v                   break;
                }
            }
           10stack.push(j);
        }
        result
    }
}