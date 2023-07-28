impl Solution {
    pub fn asteroid_collision(asteroids: Vec<i32>) -> Vec<i32> {
        
        let mut stack = Vec::new();
        for &a in asteroids.iter() {
            if a > 0 {
                stack.push(a);
            } else {
                while let Some(&s) = stack.last() {
                    if s < 0 {
                        stack.push(a);
                        break;
                    } else if s < -a {
                        stack.pop();
                    } else if s == -a {
                        stack.pop();
                        break;
                    } else {
                        break;
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