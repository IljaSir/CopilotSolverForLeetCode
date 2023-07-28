impl Solution {
    pub fn count_rectangles(rectangles: Vec<Vec<i32>>, points: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut count: Vec<i32> = vec![0; points.len()];
        for i in 0..rectangles.len() {
            let (l, h) = (rectangles[i][0], rectangles[i][1]);
            for j in 0..points.len() {
                let (x, y) = (points[j][0], points[j][1]);
                if x <= l && y <= h {
                    count[j] += 1;
                }
            }
        }
        count
    }
}