impl Solution {
    pub fn longest_nice_subarray(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut stack = vec![0];
        for n in nums {
            let mut i = 0;
            while i < stack.len() {
                if (stack[i] ^ n) < 0x20 {
                    stack[i] |= n;
                } else {
                    let tmp = stack.remove(i);
                    if tmp == 0x1F {
                        res = res.max(stack.len() as i32);
                    }
                    continue;
                }
                i += 1;
            }
        }
        res as i32
    }
}