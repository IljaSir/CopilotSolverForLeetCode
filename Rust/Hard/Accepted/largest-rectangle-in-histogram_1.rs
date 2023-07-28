impl Solution {
    pub fn largest_rectangle_area(heights: Vec<i32>) -> i32 {
        
        let mut stack = vec![-1];
        let mut max_area = 0;
        for i in 0..heights.len() {
            while stack.len() > 1 && heights[stack[stack.len() - 1] as usize] >= heights[i] {
                let height = heights[stack.pop().unwrap() as usize];
                let width = (i as i32) - stack[stack.len() - 1] - 1;
                max_area = max_area.max(height * width);
            }
            stack.push(i as i32);
        }
        while stack.len() > 1 {
            let height = heights[stack.pop().unwrap() as usize];
            let width = (heights.len() as i32) - stack[stack.len() - 1] - 1;
            max_area = max_area.max(height * width);
        }
        max_area
    }
}