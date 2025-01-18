@Override
public void simulate(Army playerArmy, Army computerArmy) throws InterruptedException {
    List<Unit> allUnits = new ArrayList<>();
    allUnits.addAll(playerArmy.getUnits());
    allUnits.addAll(computerArmy.getUnits());

    while (playerArmy.hasAliveUnits() && computerArmy.hasAliveUnits()) {
        allUnits.stream()
            .sort(Comparator.comparingInt(Unit::getBaseAttack).reversed())
            .filter(Unit::isAlive)
            .peek(unit -> {
                Unit target = unit.getProgram().attack();
                if (target != null)
                    printBattleLog.printBattleLog(unit, target);
            });
    }
}
