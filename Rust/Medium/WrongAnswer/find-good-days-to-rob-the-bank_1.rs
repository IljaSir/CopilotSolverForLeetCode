impl Solution {
    pub fn good_days_to_rob_bank(security: Vec<i32>, time: i32) -> Vec<i32> {
        
        let time = time as usize;
        let mut ans = vec![];
        let mut stack = vec![];
        for i in 0..security.len() {
            while !stack.is_empty() && security[*stack.last().unwrap()] <= security[i] {
                stack.pop();
            }
            stack.push(i);
            if i >= time && stack[0] == i - time {
                stack.remove(0);
            }
            if i >= time - 1 && stack[0] <= i - time + 1 {
                ans.push(i as i32 - time as i32 + 1);
            }
        }
        ans
    }
}