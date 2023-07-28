impl Solution {
    pub fn compute_area(ax1: i32, ay1: i32, ax2: i32, ay2: i32, bx1: i32, by1: i32, bx2: i32, by2: i32) -> i32 {
        

        let area1 = (ax2 - ax1) * (ay2 - ay1);
        let area2 = (bx2 - bx1) * (by2 - by1);
        let overlap = if ax1 < bx2 && ax2 > bx1 && ay1 < by2 && ay2 > by1 {
            let overlap_width = (ax2.min(bx2) - ax1.max(bx1)).abs();
            let overlap_height = (ay2.min(by2) - ay1.max(by1)).abs();
            overlap_width * overlap_height
        } else {
            0
        };
        area1 + area2 - overlap
    }
}