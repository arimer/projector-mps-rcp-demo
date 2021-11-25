<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:51bcb88e-b94c-47b1-ae23-11adc511051c(com.itemis.rcp.lang.sandbox.sandbox)">
  <persistence version="9" />
  <languages>
    <use id="22afb2b6-6f3c-47b7-9828-847652face44" name="com.itemis.rcp.lang" version="0" />
    <use id="f0fd486f-8577-43e9-b671-3d118449c6e7" name="org.iets3.components.core" version="7" />
  </languages>
  <imports />
  <registry>
    <language id="22afb2b6-6f3c-47b7-9828-847652face44" name="com.itemis.rcp.lang">
      <concept id="1668161615111101356" name="com.itemis.rcp.lang.structure.MyChunkContent" flags="ng" index="27xhIa" />
    </language>
    <language id="f0fd486f-8577-43e9-b671-3d118449c6e7" name="org.iets3.components.core">
      <concept id="7804632404593342574" name="org.iets3.components.core.structure.EmptyComponentsChunkContent" flags="ng" index="1i1AuW" />
      <concept id="7804632404593341326" name="org.iets3.components.core.structure.ComponentsChunk" flags="ng" index="1i1ALs">
        <child id="7804632404593342038" name="contents" index="1i1AA4" />
      </concept>
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ng" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="1i1ALs" id="1sAw2qgDoHP">
    <property role="TrG5h" value="DemoChunk" />
    <node concept="27xhIa" id="1sAw2qgDoHR" role="1i1AA4" />
    <node concept="1i1AuW" id="7YpIm7$FfKA" role="1i1AA4" />
    <node concept="27xhIa" id="7YpIm7$FfKP" role="1i1AA4" />
    <node concept="1i1AuW" id="7YpIm7$FfOH" role="1i1AA4" />
    <node concept="1i1AuW" id="7YpIm7$FfOR" role="1i1AA4" />
    <node concept="1i1AuW" id="1sAw2qgDsOU" role="1i1AA4" />
    <node concept="1i1AuW" id="7YpIm7$FfOz" role="1i1AA4" />
    <node concept="1i1AuW" id="1sAw2qgDsOZ" role="1i1AA4" />
    <node concept="1i1AuW" id="1sAw2qgDsyd" role="1i1AA4" />
  </node>
</model>

