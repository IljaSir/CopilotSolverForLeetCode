impl Solution {
    pub fn asteroid_collision(asteroids: Vec<i32>) -> Vec<i32> {
        
        let mut stack = vec![];
        for a in asteroids {
            if a > 0 {
                stack.push(a);
            } else {
                while let Some(&b) = stack.last() {
                    if b > 0 && b + a < 0 {
                        break;
                    } else if b > 0 && b + a > 0 {
                        stack.pop();
                    } else {
                        stack.push(a);
                        break;
                    }
                }
                if stack.is_empty() || *stack.last().unwrap() < 0 {
                    stack.push(a);
                }
            }
        }
        stack
    }
}