impl Solution {
    pub fn is_possible(nums: Vec<i32>) -> bool {
        

        let mut stack = vec![];
        for n in nums {
            let mut i = 0;
            while i < stack.len() {
                if stack[i].0 == n {
                    stack[i].1 += 1;
                    break;
                } else if stack[i].0 + 1 == n {
                    if i == 0 || stack[i - 1].0 != stack[i].0 {
                        stack[i].0 += 1;
                        stack[i].1 -= 1;
                        if stack[i].1 == 0 {
                            stack.remove(i);
                        }
                        break;
                    }
                }
                i += 1;
            }
            if i == stack.len() {
                stack.push((n, 2));
            }
        }
        stack.len() == 0
    }
}