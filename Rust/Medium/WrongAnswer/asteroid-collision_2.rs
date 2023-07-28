impl Solution {
    pub fn asteroid_collision(asteroids: Vec<i32>) -> Vec<i32> {
        
        let mut stack = Vec::new();
        for a in asteroids {
            if a > 0 {
                stack.push(a);
            } else {
                while let Some(&b) = stack.last() {
                    if b < 0 {
                        stack.push(a);
                        break;
                    } else if b > -a {
                        break;
                    } else if b == -a {
                        stack.pop();
                        break;
                    } else {
                        stack.pop();
                    }
                }
                if stack.is_empty() {
                    stack.push(a);
                }
            }
        }
        stack
    }
}