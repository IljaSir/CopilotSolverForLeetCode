impl Solution {
    pub fn largest_rectangle_area(heights: Vec<i32>) -> i32 {
        
        let mut max_area = 0;
        let mut stack: Vec<usize> = Vec::new();
        let mut heights = heights;
        heights.push(0);
        for i in 0..heights.len() {
            while let Some(&top) = stack.last() {
                if heights[top] >= heights[i] {
                    stack.pop();
                    let width = if let Some(&last) = stack.last() {
                        i - last - 1
                    } else {
                        i
                    };
                    let area = heights[top] * width as i32;
                    max_area = max_area.max(area);
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        max_area
    }
}