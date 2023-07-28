impl Solution {
    pub fn largest_rectangle_area(heights: Vec<i32>) -> i32 {
        
        let mut stack = Vec::new();
        let mut max_area = 0;
        let mut i = 0;
        while i < heights.len() {
            if stack.is_empty() || heights[i] > heights[*stack.last().unwrap()] {
                stack.push(i);
                i += 1;
            } else {
                let top = stack.pop().unwrap();
                let area = heights[top] * (if stack.is_empty() { i as i32 } else { i as i32 - stack.last().unwrap() as i32 - 1 });
                max_area = max_area.max(area);
            }
        }
        while !stack.is_empty() {
            let top = stack.pop().unwrap();
            let area = heights[top] * (if stack.is_empty() { i as i32 } else { i as i32 - stack.last().unwrap() as i32 - 1 });
            max_area = max_area.max(area);
        }
        max_area
    }
}