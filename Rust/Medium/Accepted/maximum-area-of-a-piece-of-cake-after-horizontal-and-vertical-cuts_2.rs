impl Solution {
    pub fn max_area(h: i32, w: i32, horizontal_cuts: Vec<i32>, vertical_cuts: Vec<i32>) -> i32 {
        
        let mut horizontal_cuts = horizontal_cuts;
        let mut vertical_cuts = vertical_cuts;
        horizontal_cuts.push(0);
        horizontal_cuts.push(h);
        vertical_cuts.push(0);
        vertical_cuts.push(w);
        horizontal_cuts.sort();
        vertical_cuts.sort();
        let mut max_h = 0;
        let mut max_w = 0;
        for i in 0..horizontal_cuts.len() - 1 {
            let h = horizontal_cuts[i + 1] - horizontal_cuts[i];
            max_h = max_h.max(h);
        }
        for i in 0..vertical_cuts.len() - 1 {
            let w = vertical_cuts[i + 1] - vertical_cuts[i];
            max_w = max_w.max(w);
        }
        let ans = max_h as i64 * max_w as i64;
        (ans % 1000000007) as i32
    }
}