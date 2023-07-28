impl Solution {
    pub fn max_area(h: i32, w: i32, horizontal_cuts: Vec<i32>, vertical_cuts: Vec<i32>) -> i32 {
        
        let mut horiz = horizontal_cuts;
        let mut vert = vertical_cuts;
        horiz.push(0);
        horiz.push(h);
        vert.push(0);
        vert.push(w);
        horiz.sort();
        vert.sort();
        let mut max_h = 0;
        let mut max_v = 0;
        for i in 0..horiz.len() - 1 {
            max_h = max_h.max(horiz[i+1] - horiz[i]);
        }
        for i in 0..vert.len() - 1 {
            max_v = max_v.max(vert[i+1] - vert[i]);
        }
        (max_h * max_v % 1000000007) as i32
    }
}