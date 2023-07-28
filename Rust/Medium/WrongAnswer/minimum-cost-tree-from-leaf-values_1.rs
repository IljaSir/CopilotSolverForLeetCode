impl Solution {
    pub fn mct_from_leaf_values(arr: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut stack = vec![i32::MAX];
        for a in arr {
            while stack.last().unwrap() <= &a {
                let mid = stack.pop().unwrap();
                res += mid * std::cmp::min(*stack.last().unwrap(), a);
            }
            stack.push(a);
        }
        while stack.len() > 2 {
            res += stack.pop().unwrap() * stack[stack.len() - 2];
        }
        res
    }
}