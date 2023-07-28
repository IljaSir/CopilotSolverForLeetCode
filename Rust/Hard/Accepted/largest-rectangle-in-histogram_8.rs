impl Solution {
    pub fn largest_rectangle_area(heights: Vec<i32>) -> i32 {
        
        let mut stack: Vec<i32> = Vec::new();
        let mut heights = heights;
        heights.push(0);
        let mut max_area = 0;
        let mut i = 0;
        while i < heights.len() {
            if stack.is_empty() || heights[stack[stack.len() - 1] as usize] < heights[i] {
                stack.push(i as i32);
                i += 1;
            } else {
                let top = stack.pop().unwrap();
                let area = heights[top as usize] * if stack.is_empty() { i as i32 } else { i as i32 - stack[stack.len() - 1] - 1 };
                max_area = max_area.max(area);
            }
        }
        max_area
    }
}