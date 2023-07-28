impl Solution {
    pub fn maximal_rectangle(matrix: Vec<Vec<char>>) -> i32 {
        
        if matrix.is_empty() {
            return 0;
        }
        let mut max_area = 0;
        let mut heights = vec![0; matrix[0].len()];
        for row in matrix {
            for (i, c) in row.iter().enumerate() {
                heights[i] = if *c == '1' { heights[i] + 1 } else { 0 };
            }
            max_area = max_area.max(Self::largest_rectangle_area(&heights));
        }
        max_area
    }
    fn largest_rectangle_area(heights: &[i32]) -> i32 {
        let mut max_area = 0;
        let mut stack = vec![];
        let mut heights = heights.to_vec();
        heights.push(0);
        for (i, &height) in heights.iter().enumerate() {
            while let Some(&top) = stack.last() {
                if heights[top] < height {
                    break;
                }
                stack.pop();
                let left = if let Some(&left) = stack.last() {
                    left
                } else {
                    0
                };
                let area = heights[top] * (i - left) as i32;
                max_area = max_area.max(area);
            }
            stack.push(i);
        }
        max_area
    }
}