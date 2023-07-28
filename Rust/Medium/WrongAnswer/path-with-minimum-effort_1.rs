impl Solution {
    pub fn minimum_effort_path(heights: Vec<Vec<i32>>) -> i32 {
        
        let rows = heights.len();
        let cols = heights[0].len();
        let mut visited = vec![vec![false; cols]; rows];
        let mut heap = std::collections::BinaryHeap::new();
        heap.push((0, (0, 0)));
        while let Some((effort, (r, c))) = heap.pop() {
            if r == rows - 1 && c == cols - 1 {
                return -effort;
            }
            if visited[r][c] { continue; }
            visited[r][c] = true;
            for (i, j) in vec![(r as i32 - 1, c as i32), (r as i32 + 1, c as i32), (r as i32, c as i32 - 1), (r as i32, c as i32 + 1)] {
                if i < 0 || i >= rows as i32 || j < 0 || j >= cols as i32 { continue; }
                let i = i as usize;
                let j = j as usize;
                let new_effort = -effort.max((heights[r][c] - heights[i][j]).abs());
                heap.push((new_effort, (i, j)));
            }
        }
        unreachable!()
    }
}