impl Solution {
    pub fn mem_leak(memory1: i32, memory2: i32) -> Vec<i32> {
        
        let mut time = 1;
        let mut mem1 = memory1;
        let mut mem2 = memory2;
        loop {
            if mem1 >= mem2 {
                if mem1 < time {
                    break;
                }
                mem1 -= time;
            } else {
                if mem2 < time {
                    break;
                }
                mem2 -= time;
            }
            time += 1;
        }
        vec![time, mem1, mem2]
    }
}